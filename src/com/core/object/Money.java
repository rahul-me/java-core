package com.core.object;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Money {
	int amount;
	String currencyCode;
	
	@Override
	public boolean equals(Object obj) {
		if (Objects.isNull(obj))
			return false;
		if (!(obj instanceof Money))
			return false;
		Money other = (Money) obj;
		return (this.amount == other.amount)
				&& ((Objects.isNull(this.currencyCode) && Objects.isNull(other.currencyCode))
						|| (this.currencyCode != null && this.currencyCode.equals(other.currencyCode)));
	}
	
}

@NoArgsConstructor
class WrongVoucher extends Money {
	
	public WrongVoucher(int amount, String currencyCode, String store) {
		this.amount = amount;
		this.currencyCode = currencyCode;
		this.store = store;
	}
	
    private String store;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WrongVoucher))
            return false;
        WrongVoucher other = (WrongVoucher)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        boolean storeEquals = (this.store == null && other.store == null)
          || (this.store != null && this.store.equals(other.store));
        return this.amount == other.amount && currencyCodeEquals && storeEquals;
    }

    // other methods
}
