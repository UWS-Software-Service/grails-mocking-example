package ie.uws.blog.mocking

import grails.test.mixin.TestFor
import org.gmock.GMockTestCase

@TestFor(ReportController)
class ReportControllerTests extends GMockTestCase {

	void testSaveIncrease() {
		def reportServiceControl = mockFor(ReportService)
		reportServiceControl.demand.saveEvent() { String name, EventType type -> }
		controller.reportService = reportServiceControl.createMock()

		controller.reportIncrease('event')

		reportServiceControl.verify()
	}

	void testSaveIncreaseWithParameterCheck() {
		def calledName = null
		def calledType = null

		def reportServiceControl = mockFor(ReportService)
		reportServiceControl.demand.saveEvent() { String name, EventType type ->
			calledName = name
			calledType = type
		}
		controller.reportService = reportServiceControl.createMock()

		controller.reportIncrease('event')

		reportServiceControl.verify()
		assertEquals('event', calledName)
		assertEquals(EventType.INCREASE, calledType)
	}

	void testSaveIncreaseUsingGMock() {
		def reportServiceMock = mock(ReportService)
		reportServiceMock.saveEvent('event', EventType.INCREASE).returns(true).once()
		controller.reportService = reportServiceMock

		play {
			controller.reportIncrease('event')
		}
	}

}
