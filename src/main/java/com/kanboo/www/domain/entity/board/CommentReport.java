package com.kanboo.www.domain.entity.board;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.board.CommentReportDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer_report")
@Builder
public class CommentReport {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_report_idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_idx")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_idx")
    private Member member;

    @Column(name = "answer_report_resn")
    private String reasonOfDelete;

    public CommentReportDTO entityToDto() {
        return CommentReportDTO.builder()
                .idx(idx)
                .member(member.entityToDto())
                .comment(comment.entityToDto())
                .reasonOfDelete(reasonOfDelete)
                .build();
    }
}
