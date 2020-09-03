package com.leetcode;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl{
    public static boolean isBadVersion(int n) {

        if (n >= 1702766719) return true;
            return false;

    }
}

public class FirstBadVersion extends VersionControl {
    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int pos = 0;
        boolean isLeft = true;
        do{
            if (isLeft)
                pos = pos + ((right - left) / 2);
            else
                pos = pos - ((right - left) / 2);

            if (!isBadVersion(pos) && isBadVersion(pos+1)) {
                return pos + 1;
            } else if (!isBadVersion(pos) && !isBadVersion(pos+1)) {
                left = pos;
                isLeft = true;
            } else {
                right = pos;
                isLeft = false;
            }
        }while(Math.abs(left - right) > 1);

        return pos;
    }

    public static void main(String[] args) {
        FirstBadVersion.firstBadVersion(2126753390);
    }
}
