from flask import Flask, request
import pprint

app = Flask(__name__)


@app.route('/action', methods=['POST'])
def process_webhook():
    body = request.json
    
    # 전체 JSON 데이터 출력
    pprint.pprint(body)
    print("\n\n\n");

    # 전체 JSON 중 outPutContext의 파라미터 출력
    pprint.pprint(body["queryResult"]["outputContexts"][0]["parameters"])

    # 전체 JSON 중 outPutContext의 파라미터 참조
    parameters = body["queryResult"]["outputContexts"][0]["parameters"]

    print(parameters["pizza-menu"])
    print(parameters["pizza-size"])
    print(parameters["number"])

    return "OK"


if __name__ == '__main__':
    app.run(debug=True)