class Solution {
    public int solution(String word, String[] pages) {
        int length = pages.length;
        int answer = 0;
        char[][] data = new char[length][];
        char[][] url = new char[length][];

        for (int i = 0; i < length; i++) {
            data[i] = pages[i].toCharArray();
        }
        return answer;
    }

    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution("", new String[] {
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"
                + "<head>\r\n"
                + "  <meta charset=\"utf-8\">\r\n"
                + "  <meta property=\"og:url\" content=\"https://a.com\"/>\r\n"
                + "</head>  \r\n"
                + "<body>\r\n"
                + "Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \r\n"
                + "<a href=\"https://b.com\"> Link to b </a>\r\n"
                + "</body>\r\n"
                + "</html>",
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"
                + "<head>\r\n"
                + "  <meta charset=\"utf-8\">\r\n"
                + "  <meta property=\"og:url\" content=\"https://b.com\"/>\r\n"
                + "</head>  \r\n"
                + "<body>\r\n"
                + "Suspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \r\n"
                + "<a href=\"https://a.com\"> Link to a </a>\r\n"
                + "blind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\r\n"
                + "<a href=\"https://c.com\"> Link to c </a>\r\n"
                + "</body>\r\n"
                + "</html>",
            "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"
                + "<head>\r\n"
                + "  <meta charset=\"utf-8\">\r\n"
                + "  <meta property=\"og:url\" content=\"https://c.com\"/>\r\n"
                + "</head>  \r\n"
                + "<body>\r\n"
                + "Ut condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\r\n"
                + "<a href=\"https://a.com\"> Link to a </a>\r\n"
                + "</body>\r\n"
                + "</html>"
        });
        System.out.println(answer);
    }
}