package ie.uws.blog.mocking

class ReportService {

	def saveEvent(String name, EventType type) {
		// TODO save event to database
	}

}

enum EventType {
	DECREASE,
	INCREASE
}