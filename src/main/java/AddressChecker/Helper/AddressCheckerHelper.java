package AddressChecker.Helper;

public class AddressCheckerHelper {
    public static String formatAddress(String address){
        String formatted = address.trim();
        formatted = formatted.replaceAll("\\s+", " ");

        formatted = formatted.replaceAll("v\\.(?![a-zA-Z])", "vägen");
        formatted = formatted.replaceAll("g\\.(?![a-zA-Z])", "gatan");

        formatted = formatted.replaceAll("(?<=[a-zA-Z])(?=\\d)", " ");

        formatted = formatted.replaceAll("\\blgh\\s*", "lgh ");
        formatted = formatted.replaceAll("\\bLgh\\s*", "lgh ");

        return formatted;
    }

    private static String capitalizeFirstLetterOfWords(String text) {
        String[] words = text.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
