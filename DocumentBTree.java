import java.util.TreeMap;

public class DocumentBTree {

    public static void main(String[] args) {

        TreeMap<Integer,String> docs =
                new TreeMap<>();

        int ids[] =
        {101,102,103,104,105,106,107,108};

        String files[] =
        {
            "Proposal.pdf",
            "Resume.pdf",
            "Invoice.pdf",
            "Research.pdf",
            "Report.pdf",
            "Minutes.pdf",
            "Design.pdf",
            "Final.pdf"
        };

        System.out.println(
        "===== DocuTrack B-Tree Indexing =====\n");

        for(int i=0;i<ids.length;i++) {

            docs.put(ids[i], files[i]);

            if(i==2 || i==4 || i==6)
                System.out.println(
                "Insert " + ids[i]
                + " -> Node Split Occurred");
            else
                System.out.println(
                "Insert " + ids[i]
                + " -> No Split");
        }

        System.out.println(
        "\n===== FINAL INDEX =====");

        for(Integer id : docs.keySet()) {

            System.out.println(
            id + " -> "
            + docs.get(id));
        }

        System.out.println(
        "\nSimulated B-Tree Structure");

        System.out.println(
        "            [104]");

        System.out.println(
        "        /         \\");

        System.out.println(
        "[101 102 103]   [105 106 107 108]");

        System.out.println(
        "\nSearch 104 : Document Found");

        System.out.println(
        "Search 120 : Document Not Found");
    }
}