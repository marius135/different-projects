import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CommitTest {
    @Test
    void findLongestCommonPath() {

        String file1 = "fdsfs/uber.rb";
        String file2 = "fdsfs/uber2.rb";
        List<String> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);
        Commit commit = new Commit("Marius", files);

        String longestCommonPath = commit.findLongestCommonPath();
        System.out.print(longestCommonPath);
        assertTrue(longestCommonPath.equals("fdsfs/"));

    }

}