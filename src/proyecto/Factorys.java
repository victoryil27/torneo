package proyecto;

public abstract class Factorys {
	Database d = Database.INSTANCE;
	abstract public Pokemon crear();
}
