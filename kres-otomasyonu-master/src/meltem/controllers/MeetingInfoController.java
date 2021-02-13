package meltem.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import meltem.models.Meeting;
import meltem.models.RouteData;
import meltem.services.SceneBuilder;
import meltem.services.data_access.concrete.MeetingRepository;
import meltem.services.logging.Logger;
import meltem.view_models.MeetingViewModel;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MeetingInfoController implements Initializable {
    public static int MeetingId = -1;

    Meeting meeting;

    @FXML
    public Text indicatorId;
    @FXML
    public Text txtMeetingId;
    @FXML
    public Text txtMeetingTitle;
    @FXML
    public Text txtMeetingDate;
    @FXML
    public TextArea txtAreaSummary;
    @FXML
    public Text lblMeetingId;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(MeetingId != -1) {

            meeting = MeetingRepository.Instance.fetchById(MeetingId);
            lblMeetingId.setText("Toplantı Kaydı #" + meeting.getMeetingId());
            txtMeetingTitle.setText(meeting.getMeetingTitle());
            txtMeetingDate.setText(meeting.getMeetingDate());
            txtAreaSummary.setText(meeting.getMeetingSummary());

        } else {
            meeting = new Meeting();
        }

    }



    @FXML
    public void goBack() throws IOException {
        SceneBuilder.Instance.BuildScene("meeting_list");
    }
}
