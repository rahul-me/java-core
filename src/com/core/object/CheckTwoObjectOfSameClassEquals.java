package com.core.object;

public class CheckTwoObjectOfSameClassEquals {
	public static void main(String[] args) {
		Money income = new Money(50, "USD");
		Money expense = new Money(50, "USD");
		
		boolean isEqual = income.equals(expense);
		
		System.out.println(isEqual);
		
		Money money = new Money(40, "USD");
		Money money2 = new Money(40, "USD");
		WrongVoucher wrongVoucher = new WrongVoucher(40, "USD", "Amazon");
		WrongVoucher wrongVoucher2 = new WrongVoucher(40, "USD", "Amazon");
		
		isEqual = money.equals(money2);
		System.out.println("Money1 is equal money2 "+isEqual);
		
		isEqual = wrongVoucher.equals(wrongVoucher2);
		System.out.println("voucher1 is equal voucher2 "+isEqual);
		
		isEqual = money.equals(wrongVoucher);
		System.out.println("Money is equal voucher "+isEqual);
		
		isEqual = wrongVoucher.equals(money);
		System.out.println("voucher is equal money "+isEqual);
		
		boolean isAssignable = wrongVoucher.getClass().isAssignableFrom(money.getClass());
		System.out.println("voucher is assignable to money "+ isAssignable);
		
		isAssignable = money.getClass().isAssignableFrom(wrongVoucher.getClass());
		System.out.println("money is assignable to voucher "+ isAssignable);
	}
}
