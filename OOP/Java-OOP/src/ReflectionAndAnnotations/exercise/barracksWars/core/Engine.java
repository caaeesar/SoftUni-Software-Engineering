package ReflectionAndAnnotations.exercise.barracksWars.core;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.*;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Runnable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter commandInterpreter;

	public Engine( CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable executable = commandInterpreter.interpretCommand(data,commandName);
				String result = executable.execute();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

/*	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		String result;
		switch (commandName) {
			case "add":
				result = new AddUnitCommand(data,repository,unitFactory).execute();
				break;
			case "report":
				result = new ReportCommand(data,repository,unitFactory).execute();
				break;
			case "fight":
				new FightCommand(data,repository,unitFactory);
				result = new FightCommand(data,repository,unitFactory).execute();
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}
		return result;
	}*/
}
