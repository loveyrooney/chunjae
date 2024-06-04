package comchunjae.entity.cascade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="board")
@Getter @Setter
public class Board extends BoardBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long boardId;
    private String title;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL
    , orphanRemoval = true)
    private List<RepBoard> replies=new ArrayList<>();

    public void addChild(RepBoard repBoard){
        replies.add(repBoard);
        repBoard.setBoard(this);
    }


}
