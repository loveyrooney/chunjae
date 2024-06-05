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

    // JPA 영속성 컨텍스트 관리를 위한 편의 메서드
    public void appendRep(RepBoard repBoard){
        replies.add(repBoard);  // OneToMay 리스트에 댓글 추가
        repBoard.setBoard(this);  // ManyToOne 댓글에 보드 추가
    }


}
