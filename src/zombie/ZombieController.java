package zombie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class ZombieController implements MouseListener {

	private final ZombieModel model;
	private final ZombieView view;
	private final int delay;
	
	public ZombieController(ZombieModel modelArg, ZombieView viewArg, int sleepTimeArg) {
		model = modelArg;
		view = viewArg;
		delay = sleepTimeArg;
	}

	public void beginSimulation() {
		model.initialize();
		view.draw();
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				model.getHuman().update();
				view.draw();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	//width 80 height 60

	
	
	@Override
	public void mousePressed(MouseEvent e) {
		int fiftDot = 15 * model.getDotSize();
		int fortfDot = 45 * model.getDotSize();
		int fortDot = 40 * model.getDotSize();
		if(e.getX() < fortDot && e.getY() > fiftDot && e.getY() < fortfDot) {
			model.getHuman().setDirection(Direction.WEST);
		} else if(e.getX() > fortDot && e.getY() > fiftDot && e.getY() < fortfDot) {
			model.getHuman().setDirection(Direction.EAST);
		} else if(e.getY() < fortfDot) {
			model.getHuman().setDirection(Direction.NORTH);
		} else if(e.getY() > fiftDot) {
			model.getHuman().setDirection(Direction.SOUTH);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}