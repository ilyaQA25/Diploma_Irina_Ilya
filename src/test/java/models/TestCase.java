package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @EqualsAndHashCode.Exclude
    private int id;
    private String title;
    //    @SerializedName(value = "_etag")
//    @EqualsAndHashCode.Exclude
//    private static final String etag = ""; // works fine without this field
    @EqualsAndHashCode.Exclude
    @SerializedName(value = "project_id")
    private int projectID;

    /*
     required???
      private int priority -- then create /models/enum package and CasePriorityId
      private String template -- then create /models/enum package and CaseTemplate STEPS or TEXT
      private String ownerName ($owner_name in api) -- then edit property
      private String projectID (project_id in api) -- then getProjectTest before
     */

}
