package mcm.projects.mypaths.client.utils;

import com.google.gwt.user.client.Command;

public class MenuCommand implements Command {
	final HistoryToken historyToken;
	
	public MenuCommand(HistoryToken historyToken) {
        this.historyToken = historyToken;
    }
	
	@Override
	public void execute() {
		historyToken.fire();	
	}

}
