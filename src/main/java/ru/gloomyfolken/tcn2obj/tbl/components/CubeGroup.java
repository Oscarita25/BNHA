package ru.gloomyfolken.tcn2obj.tbl.components;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author iChun
 * @since 0.1.0
 */
public class CubeGroup {
    public ArrayList<CubeInfo> cubes = Lists.newArrayList();
    public ArrayList<CubeGroup> cubeGroups = Lists.newArrayList();

    public String name;

    public boolean txMirror = false;

    public boolean hidden = false;

    public String identifier;
    
    @Override
    public String toString()
    {
        return name+" "+cubes+" "+cubeGroups;
    }
}
