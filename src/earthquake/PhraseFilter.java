package earthquake;

public class PhraseFilter implements Filter {

	private String position;
	private String phrase;

	public PhraseFilter(String pos, String phr) {
		position = pos;
		phrase = phr;
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		String[] titleArr = qe.getInfo().split("\\W+");
		if (position.equals("start") && titleArr[0].equals(phrase)) {
			return true;

		} else if (position.equals("any") && this.checkAnyPhrase(qe.getInfo(), phrase)) {
			return true;

		} else if (position.equals("end") && titleArr[titleArr.length - 1].equals(phrase)) {
			return true;

		}

		return false;
	}

	private boolean checkAnyPhrase(String title, String phrase) {
		int index = 0;
		while (index < title.length() - phrase.length()) {
			if (title.substring(index, index + 1).equals(phrase.substring(0, 1))
					&& title.substring(index, index + phrase.length()).equals(phrase)) {
				return true;
			}
			index++;
		}
		return false;
	}
}
