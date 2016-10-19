package enums;

public enum Status {

	OK(0, 1) {
		@Override
		public String getMessage() {
			return "200 OK";
		}
	},
	
	ERROR(1, -1) {
		@Override
		public String getMessage() {
			return "500 ERROR";
		}
	};

	private int id;
	private int value;

	Status(int id, int value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public int getValue() {
		return value;
	}

	public abstract String getMessage();

	public static void main(String[] args) {
		System.out.println(Status.ERROR.getId());
		System.out.println(Status.ERROR.getValue());
		System.out.println(Status.ERROR.getMessage());
		System.out.println(Status.OK.getId());
		System.out.println(Status.OK.getValue());
		System.out.println(Status.OK.getMessage());
	}
}
