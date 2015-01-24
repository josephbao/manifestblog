package manifestblog

class Comment {
	String content;
	Date date;
	static belongsTo=[user:User,post:Post];
    static constraints = {
    }
}
