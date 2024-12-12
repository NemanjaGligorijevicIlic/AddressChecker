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

        formatted = formatted.replaceAll("(?<=\\d)([a-z])", " $1");
        StringBuilder result = new StringBuilder();
        for (String word : formatted.split(" ")) {
            if (word.length() == 1 && Character.isLowerCase(word.charAt(0))) {
                result.append(Character.toUpperCase(word.charAt(0))).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
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
