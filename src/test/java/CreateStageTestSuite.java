import com.kodilla.battleship.CreateStage;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateStageTestSuite {

    @Test
    void createStartStageTest(){
        //given
        CreateStage createStage = new CreateStage();

        //when
        Stage startStage = createStage.createStartStage();
        String stageTitle = startStage.getTitle();

        //
        assertEquals("Battleship", stageTitle);
    }

}
