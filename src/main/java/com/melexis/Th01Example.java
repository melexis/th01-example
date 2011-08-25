package com.melexis;

import java.io.InputStream;
import java.io.FileInputStream;

import com.melexis.th01.TH01Die;
import com.melexis.th01.TH01WaferMap;

public class Th01Example {

    private final InputStream is;

    public Th01Example(final InputStream is) {
        this.is = is;
    }

    public String printWafermap() throws Exception {
        final byte[] buff = new byte[is.available()];
        is.read(buff);
        final TH01WaferMap th01 = new TH01WaferMap(buff);
        final StringBuffer sb = new StringBuffer();

        for (final TH01Die[] line: th01.wafermap()) {
            for (final TH01Die d: line) {
                if (d != null) {
                    sb.append(String.format("%2d", d.getBincode()));
                } else {
                    sb.append("  ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage:  Th01Example <<filename>>");
            return;
        }

        final String filename = args[0];
        final InputStream is = new FileInputStream(filename);

        final Th01Example example = new Th01Example(is);
        System.out.println(example.printWafermap());
    }
}