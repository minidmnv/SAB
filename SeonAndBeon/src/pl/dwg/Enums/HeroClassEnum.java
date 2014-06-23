package pl.dwg.Enums;

public enum HeroClassEnum {
	WARRIOR(1L), MAGE(2L), ROGUE(3L), BERSERKER(4L), TEMPLAR(5L), FIRE_MAGE(6L), ICE_MAGE(7L), GADGETER(8L), 
		ASSASSIN(9L);
	
	private final Long idClass;
	
	private HeroClassEnum(Long idClass) {
		this.idClass = idClass;
	}
	
	public String getDescription() {
		switch(this) {
		case WARRIOR:
			return "Warrior";
		case MAGE:
			return "Mage";
		case ROGUE:
			return "Rogue";
		case BERSERKER:
			return "Berserker";
		case TEMPLAR:
			return "Templar";
		default:
			return "Not defined yet";
		
		}
	}
	
	public String getDescriptionLong() {
		switch(this) {
		case WARRIOR:
			return "Warrior - known as FUCKING KILLER";
		default:
			return "Not defined yet, bitch!";
		
		}
	}

	public Long getIdClass() {
		return idClass;
	}
}
