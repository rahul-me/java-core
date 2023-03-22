package com.core.object;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Team {
	String city;
	String department;

	@Override
	public boolean equals(Object obj) {
		if (Objects.isNull(obj))
			return false;
		if (this == obj)
			return true;
		if (!(obj instanceof Team))
			return false;
		Team team = (Team) obj;

		boolean isSameCity = (this.city == null && team.city == null)
				|| (this.city != null && this.city.equals(team.city));
		boolean isSameDepartment = (this.department == null && team.department == null)
				|| (this.department != null && this.department.equals(team.department));
		return isSameCity && isSameDepartment;
	}
}
