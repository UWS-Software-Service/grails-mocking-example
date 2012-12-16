package ie.uws.blog.mocking

class ReportController {

	def reportService

    def reportIncrease(String eventName) {
		reportService.saveEvent(eventName, EventType.INCREASE)
    }

}
