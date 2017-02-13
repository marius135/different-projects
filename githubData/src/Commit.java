import java.util.List;

public class Commit {

    String author;
    List<String> m_fileNames;

    void generateFilesFromReader(GithubFileReader reader) {
        m_fileNames = reader.parseFiles();
    }
    Commit (String author, List<String> fileNames) {
        this.author = author;
        this.m_fileNames = fileNames;
    }

    String findLongestCommonPath() {

        if (m_fileNames.size() == 0) {
            return "";
        }
        String solution = m_fileNames.get(0);

        for (int i = 1; i < m_fileNames.size(); ++i) {
            solution = longestCommonPath(solution, m_fileNames.get(i));
        }
        return solution;

    }

    private String longestCommonPath(String first, String second) {

        String dir1[] = first.split("/");
        String dir2[] = second.split("/");

        String solution = "";
        for (int i = 0; i < dir1.length && i < dir2.length; ++i) {
            if (dir1[i].equals(dir2[i])) {
                solution += dir1[i] + "/";
            }
        }
        return solution;
    }
}
