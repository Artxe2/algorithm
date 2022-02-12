const ajax = config => {
	var req = new XMLHttpRequest()

	req.onreadystatechange = () => {
		if (req.readyState == 4) {
			if (req.status == 200) {
				if (!config.success) {
					alert(req.responseText)
				} else {
					config.success(req.responseText)
				}
			} else {
				if (!config.error) {
					alert(req.status)
				} else {
					config.error(req.status)
				}
			}
		}
	}
	req.open(
			config.method == undefined ? "GET" : config.method,
			config.url + (config.param == undefined ? "" : config.param),
			config.async == undefined ? true : config.async,
	)
	req.send()
}