import java.util.*;
import java.util.regex.Pattern;

// Represents a single page in the book
class Page {
    private int pageNumber;
    private String content;
    
    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
    
    public String getContent() {
        return content;
    }
    
    @Override
    public String toString() {
        return "Page " + pageNumber + ": " + 
               (content.length() > 100 ? content.substring(0, 100) + "..." : content);
    }
}

// Represents search results
class SearchResult {
    private Page page;
    private List<String> matchedLines;
    private int matchCount;
    
    public SearchResult(Page page, List<String> matchedLines, int matchCount) {
        this.page = page;
        this.matchedLines = matchedLines;
        this.matchCount = matchCount;
    }
    
    public Page getPage() { return page; }
    public List<String> getMatchedLines() { return matchedLines; }
    public int getMatchCount() { return matchCount; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Page ").append(page.getPageNumber())
          .append(" (").append(matchCount).append(" matches):\n");
        
        for (String line : matchedLines) {
            sb.append("  - ").append(line).append("\n");
        }
        return sb.toString();
    }
}

// Main Book class with page finding capabilities
public class BookPageFinder {
    private List<Page> pages;
    private Map<String, Set<Integer>> wordIndex;
    
    public BookPageFinder() {
        this.pages = new ArrayList<>();
        this.wordIndex = new HashMap<>();
    }
    
    // Add a page to the book
    public void addPage(int pageNumber, String content) {
        Page page = new Page(pageNumber, content);
        pages.add(page);
        indexPage(page);
    }
    
    // Build word index for faster searching
    private void indexPage(Page page) {
        String[] words = page.getContent().toLowerCase()
                           .replaceAll("[^a-zA-Z0-9\\s]", "")
                           .split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordIndex.computeIfAbsent(word, k -> new HashSet<>())
                         .add(page.getPageNumber());
            }
        }
    }
    
    // Find pages containing a specific word or phrase
    public List<SearchResult> findByText(String searchText) {
        List<SearchResult> results = new ArrayList<>();
        String searchLower = searchText.toLowerCase();
        
        for (Page page : pages) {
            String contentLower = page.getContent().toLowerCase();
            
            if (contentLower.contains(searchLower)) {
                List<String> matchedLines = new ArrayList<>();
                int matchCount = 0;
                
                String[] lines = page.getContent().split("\n");
                for (String line : lines) {
                    if (line.toLowerCase().contains(searchLower)) {
                        matchedLines.add(line.trim());
                        matchCount += countOccurrences(line.toLowerCase(), searchLower);
                    }
                }
                
                if (!matchedLines.isEmpty()) {
                    results.add(new SearchResult(page, matchedLines, matchCount));
                }
            }
        }
        
        // Sort by relevance (match count)
        results.sort((a, b) -> Integer.compare(b.getMatchCount(), a.getMatchCount()));
        return results;
    }
    
    // Find pages using multiple keywords (AND search)
    public List<SearchResult> findByKeywords(String... keywords) {
        if (keywords.length == 0) return new ArrayList<>();
        
        // Find pages that contain all keywords
        Set<Integer> candidatePages = null;
        
        for (String keyword : keywords) {
            Set<Integer> pagesWithKeyword = wordIndex.get(keyword.toLowerCase());
            if (pagesWithKeyword == null || pagesWithKeyword.isEmpty()) {
                return new ArrayList<>(); // If any keyword is not found, return empty
            }
            
            if (candidatePages == null) {
                candidatePages = new HashSet<>(pagesWithKeyword);
            } else {
                candidatePages.retainAll(pagesWithKeyword);
            }
        }
        
        // Build results for candidate pages
        List<SearchResult> results = new ArrayList<>();
        for (Integer pageNum : candidatePages) {
            Page page = getPageByNumber(pageNum);
            if (page != null) {
                List<String> matchedLines = new ArrayList<>();
                int totalMatches = 0;
                
                String[] lines = page.getContent().split("\n");
                for (String line : lines) {
                    String lineLower = line.toLowerCase();
                    boolean lineHasMatch = false;
                    int lineMatches = 0;
                    
                    for (String keyword : keywords) {
                        if (lineLower.contains(keyword.toLowerCase())) {
                            lineHasMatch = true;
                            lineMatches += countOccurrences(lineLower, keyword.toLowerCase());
                        }
                    }
                    
                    if (lineHasMatch) {
                        matchedLines.add(line.trim());
                        totalMatches += lineMatches;
                    }
                }
                
                if (!matchedLines.isEmpty()) {
                    results.add(new SearchResult(page, matchedLines, totalMatches));
                }
            }
        }
        
        results.sort((a, b) -> Integer.compare(b.getMatchCount(), a.getMatchCount()));
        return results;
    }
    
    // Find pages by page number range
    public List<Page> findByPageRange(int startPage, int endPage) {
        return pages.stream()
                   .filter(p -> p.getPageNumber() >= startPage && p.getPageNumber() <= endPage)
                   .sorted((a, b) -> Integer.compare(a.getPageNumber(), b.getPageNumber()))
                   .toList();
    }
    
    // Find pages using regex pattern
    public List<SearchResult> findByPattern(String regexPattern) {
        List<SearchResult> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        
        for (Page page : pages) {
            List<String> matchedLines = new ArrayList<>();
            int matchCount = 0;
            
            String[] lines = page.getContent().split("\n");
            for (String line : lines) {
                if (pattern.matcher(line).find()) {
                    matchedLines.add(line.trim());
                    matchCount++;
                }
            }
            
            if (!matchedLines.isEmpty()) {
                results.add(new SearchResult(page, matchedLines, matchCount));
            }
        }
        
        results.sort((a, b) -> Integer.compare(b.getMatchCount(), a.getMatchCount()));
        return results;
    }
    
    // Get page by specific number
    public Page getPageByNumber(int pageNumber) {
        return pages.stream()
                   .filter(p -> p.getPageNumber() == pageNumber)
                   .findFirst()
                   .orElse(null);
    }
    
    // Get all pages containing any of the keywords (OR search)
    public List<SearchResult> findByAnyKeyword(String... keywords) {
        Set<Integer> allCandidatePages = new HashSet<>();
        
        for (String keyword : keywords) {
            Set<Integer> pagesWithKeyword = wordIndex.get(keyword.toLowerCase());
            if (pagesWithKeyword != null) {
                allCandidatePages.addAll(pagesWithKeyword);
            }
        }
        
        List<SearchResult> results = new ArrayList<>();
        for (Integer pageNum : allCandidatePages) {
            Page page = getPageByNumber(pageNum);
            if (page != null) {
                List<String> matchedLines = new ArrayList<>();
                int totalMatches = 0;
                
                String[] lines = page.getContent().split("\n");
                for (String line : lines) {
                    String lineLower = line.toLowerCase();
                    boolean lineHasMatch = false;
                    int lineMatches = 0;
                    
                    for (String keyword : keywords) {
                        if (lineLower.contains(keyword.toLowerCase())) {
                            lineHasMatch = true;
                            lineMatches += countOccurrences(lineLower, keyword.toLowerCase());
                        }
                    }
                    
                    if (lineHasMatch) {
                        matchedLines.add(line.trim());
                        totalMatches += lineMatches;
                    }
                }
                
                if (!matchedLines.isEmpty()) {
                    results.add(new SearchResult(page, matchedLines, totalMatches));
                }
            }
        }
        
        results.sort((a, b) -> Integer.compare(b.getMatchCount(), a.getMatchCount()));
        return results;
    }
    
    // Helper method to count occurrences
    private int countOccurrences(String text, String searchText) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(searchText, index)) != -1) {
            count++;
            index += searchText.length();
        }
        return count;
    }
    
    // Get total number of pages
    public int getTotalPages() {
        return pages.size();
    }
    
    // Get book statistics
    public void printBookStats() {
        System.out.println("=== Book Statistics ===");
        System.out.println("Total pages: " + pages.size());
        System.out.println("Total unique words: " + wordIndex.size());
        
        if (!pages.isEmpty()) {
            int minPage = pages.stream().mapToInt(Page::getPageNumber).min().orElse(0);
            int maxPage = pages.stream().mapToInt(Page::getPageNumber).max().orElse(0);
            System.out.println("Page range: " + minPage + " - " + maxPage);
        }
        System.out.println();
    }
    
    // Demo method with sample data
    public static void main(String[] args) {
        BookPageFinder book = new BookPageFinder();
        
        // Add sample pages
        book.addPage(1, "Chapter 1: Introduction to Java Programming\nJava is a powerful programming language.\nIt's used for web development, mobile apps, and enterprise software.");
        book.addPage(5, "Object-Oriented Programming\nJava supports classes, objects, inheritance, and polymorphism.\nEncapsulation is a key concept in Java programming.");
        book.addPage(10, "Data Structures in Java\nArrays, Lists, Maps, and Sets are fundamental data structures.\nThe Collections framework provides powerful utilities.");
        book.addPage(15, "Exception Handling\nJava uses try-catch blocks for error handling.\nChecked and unchecked exceptions have different behaviors.");
        book.addPage(20, "Advanced Java Features\nGenerics provide type safety.\nLambda expressions enable functional programming paradigms.");
        
        // Demonstrate different search capabilities
        System.out.println("=== BOOK PAGE FINDER DEMO ===\n");
        
        book.printBookStats();
        
        // Text search
        System.out.println("1. Searching for 'programming':");
        List<SearchResult> results = book.findByText("programming");
        results.forEach(System.out::println);
        
        // Keyword search (AND)
        System.out.println("2. Searching for pages with both 'Java' AND 'objects':");
        results = book.findByKeywords("Java", "objects");
        results.forEach(System.out::println);
        
        // Keyword search (OR)
        System.out.println("3. Searching for pages with 'Arrays' OR 'Lambda':");
        results = book.findByAnyKeyword("Arrays", "Lambda");
        results.forEach(System.out::println);
        
        // Page range search
        System.out.println("4. Getting pages 1-10:");
        List<Page> pageRange = book.findByPageRange(1, 10);
        pageRange.forEach(System.out::println);
        
        // Regex search
        System.out.println("\n5. Finding pages with words ending in 'ing':");
        results = book.findByPattern("\\w+ing\\b");
        results.forEach(System.out::println);
        
        // Specific page lookup
        System.out.println("6. Getting specific page 15:");
        Page page15 = book.getPageByNumber(15);
        if (page15 != null) {
            System.out.println(page15);
        }
    }
}