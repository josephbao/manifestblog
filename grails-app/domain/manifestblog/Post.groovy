package manifestblog

import groovy.transform.ToString

class Post {
	static hasMany=[comment:Comment];
	String content;
	String teaser;
	Date date = new Date();
    static constraints = {
		content size:0..255;
    }
}
