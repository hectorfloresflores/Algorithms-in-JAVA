package com.leetcode;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl{
    public boolean isBadVersion(int n) {

    }
}

public class FirstBadVersion extends VersionControl {
    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int pos = 0;
        Math.sum(1,2);
        do{
            pos = pos + ((right - left) / 2);

            if (isBadVersion(pos) == false && isBadVersion(pos + 1) == true) {
                return pos + 1;
            } else if (isBadVersion(pos) == false && isBadVersion(pos + 1) == false) {
                left = pos;
            } else {
                right = -pos;
            }
        }while(right != 0 || left != (n - 1));

        return isBad(pos);
    }

    public static void main(String[] args) {
        FirstBadVersion.FirstBadVersion(5);
    }
}
