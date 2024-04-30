package com.chunjae.set;

import com.chunjae.cast.Person;
import com.chunjae.list.MemberDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class SetPerson {
    private Set<Person> personSet;
    private Set<MemberDTO> memberDTOSet;

    public SetPerson(Set<MemberDTO> memberDTOSet) {
        this.memberDTOSet = memberDTOSet;
    }
}
