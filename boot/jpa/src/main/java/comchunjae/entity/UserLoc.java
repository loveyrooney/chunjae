package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="userloc")
@Getter @Setter
public class UserLoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long locationId;
    @Column(name="street_address",length = 40)
    private String streetAddress;
    @Column(name="postal_code",length = 12)
    private String postalCode;
    @Column(length = 30, nullable = false)
    private String city;
    @Column(name="state_province",length = 20)
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private UserCountry userCountry;


}
