package org.ejaeger.springframework.context.support;

/**
 * Created by zyp on 2021/11/30 4:39 下午
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] locations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String location) {
        this(new String[]{location});
    }

    public ClassPathXmlApplicationContext(String[] locations) {
        this.locations = locations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return locations;
    }
}
