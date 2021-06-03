package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.vladmihalcea.hibernate.type.range.PostgreSQLRangeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.range.Range;
import java.time.LocalDateTime;


@Entity
@Table(schema = "fizjoterapia", name = "termin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@TypeDef(
        typeClass = PostgreSQLRangeType.class,
        defaultForType = Range.class
)

public class DateOfTheVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_terminu")
    private Long dateId;

    @Column(name = "okres",
    columnDefinition = "tsrange")
    private Range<LocalDateTime> dateRange;


    public DateOfTheVisitDto dto(){
        return DateOfTheVisitDto.builder()
                .id(this.getDateId())
                .lowerBound(this.dateRange.lower().toString())
                .upperBound(this.dateRange.upper().toString())
                //.date(this.dateRange.lower().toLocalDate())
                .build();
    }

}
