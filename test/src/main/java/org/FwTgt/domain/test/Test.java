package org.FwTgt.domain.test;

import org.FwTgt.domain.Bot;
import org.FwTgt.domain.enums.EWeapon;

public class Test {
    public static void main(String[] args) {
        Bot bot = new Bot();
        EWeapon weapon=EWeapon.ak47;
        System.out.println(String.valueOf(weapon));
    }
}
