package transitdroid.domain.logic.command.pass.validate;

import transitdroid.domain.entities.card.ICard;

class ValidatePassCommandRequest{
	private ICard card;

	public ICard getCard() {
		return card;
	}

	public void setCard(ICard card) {
		this.card = card;
	}


}
