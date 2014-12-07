package com.mycompany.gs;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.omnifaces.util.Faces.getMetadataAttributes;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.omnifaces.util.Faces;

@ManagedBean
@RequestScoped
public class Page extends AbstractPage<BaseLevelBean> {
	
	private String title;
	private String path;
	private String viewId;
	
	@ManagedProperty("#{app.pages[view.viewId]}")
	private Page current;
	private AtomicBoolean loaded = new AtomicBoolean();
	
	public Page() {
	}

	public Page(String title) {
		this.title = title;
	}

	public Page(String path, String viewId, String title) {
		this.path = path;
		this.viewId = viewId;
		this.title = title;
	}
	
	@PostConstruct
	public void init() {
//		if (current != null) {
			loadIfNecessary();
//		}
	}

	private void loadIfNecessary() {
		if (loaded.getAndSet(true)) {
			return;
		}
		
		// TODO: implement here
		try {
			String viewId2 = Faces.getViewId();
			Map<String, Object> attributes = getMetadataAttributes(viewId2);
			
			BaseLevelBean level1Bean = (BaseLevelBean) attributes.get("level1");
			BaseLevelBean level2Bean = (BaseLevelBean) attributes.get("level2");
			
			setLevel1(level1Bean);
			setLevel2(level2Bean);
		
//			List<String> apiPaths = new ArrayList<>(getCommaSeparatedAttribute(attributes, "api.path"));
//			List<String> vdlPaths = getCommaSeparatedAttribute(attributes, "vdl.paths");
//			List<String> srcPaths = getCommaSeparatedAttribute(attributes, "src.paths");
//			description = loadDescription(apiPaths);
//			loadLevels();
			
		}
		catch (Exception e) {
			loaded.set(false);
			throw e;
		}
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public Page getCurrent() {
		return current;
	}

	public void setCurrent(Page current) {
		this.current = current;
	}


	public static class PageLevel<Level> implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String title;
		private String type;
		private String code;

		public PageLevel(String title, String type, String code) {
			this.title = title;
			this.type = type;
			this.code = code;
		}
		
	}

}
