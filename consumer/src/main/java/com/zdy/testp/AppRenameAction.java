package com.zdy.testp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AppRenameAction
{

    public static void main(final String[] args) throws IOException
    {
        renameFile();
    }

    public static void renameFile() throws IOException
    {
        final File parent = new File("E:/shortrent_6.5.1");
        if (parent.isDirectory())
        {
            final File[] files = parent.listFiles();
            for (final File item : files)
            {
                if (item.isFile())
                {
                    System.out.println("oldName: " + item.getName());
                    System.out.println("newName: " + item.getName().replace("shortrent_6.5.1_", "mayi_"));
                    final String absoluteName = "c:" + File.separator + "mayi_6.5.1" + File.separator
                            + item.getName().replace("shortrent_6.5.1_", "mayi_");
                    System.out.println("absoluteName:" + absoluteName);
                    FileUtils.copyFile(item, new File(absoluteName));
                }
            }
            System.out.println("done!");
        }
    }
}
