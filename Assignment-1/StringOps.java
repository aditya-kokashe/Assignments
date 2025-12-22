class StringOps {
    public static void main(String[] args) {
        String s = " Hello World ";

        System.out.println(s.length());
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(1));
        System.out.println(s.toString());
        System.out.println(s.equals("Hello"));
        System.out.println(s.compareTo("Hello"));
        System.out.println(s.contains("World"));
        System.out.println(s.indexOf("o"));
        System.out.println(s.lastIndexOf("o"));
        System.out.println(s.startsWith(" "));
        System.out.println(s.endsWith(" "));
        System.out.println(s.matches(".*World.*"));
        System.out.println(s.substring(1, 6));
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.replace("World", "Java"));

        String[] arr = s.split(" ");
        for (String x : arr) System.out.println(x);

        System.out.println(String.join("-", "A", "B", "C"));
        System.out.println(String.valueOf(100));
    }
}
