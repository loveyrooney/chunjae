package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="usercountry")
@Getter @Setter
public class UserCountry {
    @Id
    @Column(name="country_id",length = 2)
    private Character countryId;
    @Column(name="country_name",length = 40)
    private String countryName;

}
