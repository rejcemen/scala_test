import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.{JsArray, Json}

/**
  * Created by d.merkuryev on 04.05.2018
  */
class ExampleTestMsisdn extends FlatSpec with Matchers {
  val jsonResponse = Json.parse(
    """
      |{
      |  "payload": {
      |    "searchId": "6dfae692-62aa-4c17-94e9-cb4f06054271",
      |    "phones": [
      |      {
      |        "number": "79260053123",
      |        "serviceId": "2029",
      |        "score": 11,
      |        "highlights": [
      |          {
      |            "from": 8,
      |            "to": 11
      |          }
      |        ]
      |      },
      |      {
      |        "number": "79260047123",
      |        "serviceId": "2002",
      |        "score": 11,
      |        "highlights": [
      |          {
      |            "from": 8,
      |            "to": 11
      |          }
      |        ]
      |      }
      |    ]
      |  },
      |  "resultCode": "OK",
      |  "trackingId": "e4a0169d-cd37-48bb-8731-8927e64edfee"
      |}
    """.stripMargin)

  "msisdn" should "return status OK when requested" in {
    (jsonResponse \ "resultCode").as[String] shouldBe "OK"
  }

  "msisdn" should "return 2 phone numbers for search with limit 2" in {
    (jsonResponse \\ "number").map(_.as[String]) should have size 2
  }

  "msisdn" should "return numbers only for serviceIds 2029, 2002" in {
    (jsonResponse \\ "serviceId").map(_.as[String]) should contain theSameElementsAs Seq("2029", "2002")
  }

  "msisdn" should "return serviceId 2002 for number 79260047123" in {
    val foundPhone = (jsonResponse \ "payload" \ "phones").as[JsArray].value.find(s => (s \ "number").as[String] == "79260047123")
    foundPhone.map(p => (p \ "serviceId").as[String]) shouldBe Some("2002")
  }

  "msisdn" should "return non empty searchId" in {
    (jsonResponse \ "payload" \ "searchId").as[String] should not be empty
  }
}
