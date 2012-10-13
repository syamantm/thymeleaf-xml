package com.syamantakm.thymeleaf.xml;

/**
 * @author Syamantak Mukhopadhyay
 */
public  class ModelAndView<T> extends Model {

    T view;

    public void apply(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

}
