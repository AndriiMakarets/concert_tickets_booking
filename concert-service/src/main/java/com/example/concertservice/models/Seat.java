import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "row_number")
    private int rowNumber;  // номер ряду

    @Column(name = "seat_number")
    private int seatNumber;  // номер місця

    @Column(name = "is_occupied")
    private boolean isOccupied;  // чи зайняте місце

    @Column(name = "category")
    private String category;  // категорія місця (наприклад, VIP, стандарт тощо)

    @Column(name = "price")
    private double price;  // ціна місця
}
