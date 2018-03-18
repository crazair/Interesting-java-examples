package anosv.ijs.аnalyzer;

public class MainTextAnalyzer {

    public static void main(String[] args) {

        TextAnalyzer[] analyzers = new TextAnalyzer[]{
                new SpamAnalyzer("гол", "хрень"),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(10),
        };

        MainTextAnalyzer mta = new MainTextAnalyzer();
        System.out.println(mta.checkLabels(analyzers, "В хрен ь всв 123412341234"));
    }


    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label leb;
            leb = analyzer.processText(text);
            if (leb != Label.OK) {
                return leb;
            }
        }
        return Label.OK;
    }
}


enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}


interface TextAnalyzer {
    Label processText(String text);
}


abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        for (String str : getKeywords()) {
            if (text.contains(str)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    SpamAnalyzer(String... keys) {
        keywords = new String[keys.length];
        System.arraycopy(keys, 0, keywords, 0, keys.length);
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] negativ = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return negativ;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    TooLongTextAnalyzer(int max) {
        maxLength = max;
    }

    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}