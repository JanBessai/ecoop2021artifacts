package coco.ep.m5;

import util.Tree;

public interface Exp<FT> extends coco.ep.m4.Exp<FT>, Factory<FT> {

    Tree astree();

    Integer id();
}
