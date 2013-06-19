package com.mycompany.helloweb;

import java.io.File;
import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

@ManagedBean
@ViewScoped
public class PhotoCamBean implements Serializable {

	private static final long serialVersionUID = -1547017829414754592L;

	private String photo;

	private String getRandomImageName() {
		final int i = (int) (Math.random() * 10000000);

		return String.valueOf(i);
	}

	public void oncapture(final CaptureEvent captureEvent) {
		setPhoto(getRandomImageName());
		final byte[] data = captureEvent.getData();

		final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
				.getContext();
		final String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator
				+ this.photo + ".png";

		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		} catch (final Exception e) {
			e.printStackTrace();
			throw new FacesException("Error in writing captured image.");
		}
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

}
