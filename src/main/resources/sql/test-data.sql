INSERT INTO problem(json) VALUES('<?xml version="1.0" encoding="UTF-8"?>\r\n<root xmlns="http://www.java5.ru/problem">\r\n  <info>\r\n    <source>http://www.afportal.ru/physics/task/magnetism/phenomena/2</source>\r\n    <path>взято с сайта</path>\r\n  </info>\r\n  <task>\r\n    <p>Большие сверхпроводящие катушки в будущем могут быть использованы как накопители энергии. Пусть сила тока в такой катушке с индуктивностью 100 Гн равна 10 кА. Сколько льда, взятого при температуре 0°С, можно превратить в воду и нагреть до 100° С за счет энергии магнитного поля этой катушки.</p>\r\n  </task>\r\n  <solution>\r\n    <p>Энергия сверхпроводящей катушки:</p>\r\n    <p>\r\n      <formula>\r\n        <math><![CDATA[<math xmlns="http://www.w3.org/1998/Math/MathML">\r\n  <apply>\r\n    <eq/>\r\n    <ci>W</ci>\r\n    <apply>\r\n      <times/>\r\n      <ci>L</ci>\r\n      <apply>\r\n        <divide/>\r\n        <apply>\r\n          <power/>\r\n          <ci>I</ci>\r\n          <cn>2</cn>\r\n        </apply>\r\n        <cn>2</cn>\r\n      </apply>\r\n    </apply>\r\n  </apply>\r\n</math>]]></math>\r\n        <png>data:image/png;charset=utf-8;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAAZCAYAAABkdu2NAAACiklEQVR42t2XP+g5YRjAlSRJUpJMUjJIBotJBiXJZJEkg8VgMEgZZLBJBpNNkmQxSAYDyahkkiwGSVJIMun59bzlunPne/xyg3vq7e7e97173s/7/HtPAiIRiURCGqtfLHD0q+gAn0FFCcgF97OAtVqNAKnVanECoiiVShiNRuKMwd1uBxqNhpVBRQPYarUgFAq9F5u/CBiJREgcfgQolUopM9N3Z7VakT7cNbrY7XZqfiAQ+Nriz+czw+WazSZrjl6vh81m8xngcrkkH/T5fHC/36kJqVSKU9HtdiP96XSaMf+bWRJ1P8tkMgGFQvF++aA/oBXj8Tj1fL1eKUvV63XGi41GAywWy9fhUFAX6pzP56wxLA049rGLouDORKNR6rlcLkOpVGIBIhTC9Xo9wWLsEyu9DYi7Qwe0Wq1wuVxYgMViEfx+v2BJxGQyQTAYZPUfj0cYDoe87XQ6cQNqtVoIh8PkHq3ziAE64OFwAJ1OR5LPO6f7V+2VbLdbMo6e8yy4eL7vYnscAFiALpeLyqBut5sknmfAZDIJmUxG0BqH+sbjMWsMLYOL52svLYhuh4CLxQK8Xi/DGgiI/QaDgbitUBKLxUAmk30teTEAsZ4hYCKRgMFgwADErIkl5O3s9Z8uajabwePx8H4fywV6mVwuB6PRCN1ulx8QAxstZ7PZWIvFnXU4HIKfMVFXLpej+mazGUk6XBv4CBuEQ8/iBcQEgy9WKhVOa0ynU0EB8/k80fOwxn6/B6fTSTb3L0F3xr8LXkAsETgRTylcFhRSOp3OS3dut9t/vlutVjmzrij+6Pv9PhQKBXH9TdCt/spyPw+I9S6bzZL79XpNsqmoADGz0uNUpVJxzvsHiNzyvl9xaucAAAAASUVORK5CYII=</png>\r\n      </formula>\r\n    </p>\r\n    <p>при 100% использовании этой энергии на плавление и нагревание будет:</p>\r\n    <p>\r\n      <formula>\r\n        <math><![CDATA[<math xmlns="http://www.w3.org/1998/Math/MathML">\r\n  <apply>\r\n    <eq/>\r\n    <apply>\r\n      <divide/>\r\n      <apply>\r\n        <power/>\r\n        <ci>I</ci>\r\n        <cn>2</cn>\r\n      </apply>\r\n      <cn>2</cn>\r\n    </apply>\r\n    <apply>\r\n      <plus/>\r\n      <apply>\r\n        <times/>\r\n        <ci>dm</ci>\r\n      </apply>\r\n      <apply>\r\n        <times/>\r\n        <ci>c</ci>\r\n        <ci>m</ci>\r\n        <ci>dt</ci>\r\n      </apply>\r\n    </apply>\r\n  </apply>\r\n</math>]]></math>\r\n        <png>data:image/png;charset=utf-8;base64,iVBORw0KGgoAAAANSUhEUgAAAGoAAAAZCAYAAADZl7v4AAADtElEQVR42u1YT0Q8YRgekpUkS5IkWTqsPSTRKUm3pNNasvaQbntca8XqkHToknRIIkmHpEuHDllLdUjWWtKh01pWkqzUJlkreX+el2/MzE47O+3sb4bmYcx+73zf7Pt+z/vvG4kMIEkSXy7shWREkvLuwqFEaQlz4WCiXJIcSNTBwQET093d7RLl9Ijq7Oykq6srt0Y5majn52fyer01HZ9LlMOIOj4+pvn5eXdXnE5UJBLhOmUHPj4+/lQEm7VXNaOvr48eHx9tUz6bzf6pVGvGXnnG9fU1dXR02B/if6wm6tk7NzdXI5NHaMnx0K7U97+IcpoTaO2tVCrk8Xh+JsoO3N3d0fT0NCuGY0E4HFYpXq1W5XF7ezu9vLxwHUXk+3w+SqfTVCqVeB3eMTg4KB8trCAK75qamuJ34xoeHmb5yckJv6etrY0+Pz9pc3OTywac/ejoiOtPMBhkndfX1xu29/z8XCZJW7+kt7c3ury8NLzK5bKlJBUKBerq6qJAIEAPDw/0/f1NsVisxsPu7+9lopaWltjj9vf3WTY0NETxeJwJFbKRkRFLiDo8POS5s7Oz7AxPT0+qtSsrKzQ6OkqJRIKJg/4Y4/+Xl5fp/f2dZmZmqKenx5S9P2UVCSRoGdS76nmq0Vo9LCws8DN4kTLs6yn++vpaE2laGQhtlihsJKIWUYLo0EM0GqXe3l7a3d2VZaFQiKMsn8/LNiLKf2uvSoZIAQlGl9URhYM1lMEGGyrZhMzIkfSAiMCz1dXVH/VHShwbG1PJEFEgSwDRKM6lTdtrV32C59XbVCuJMhtRSF+Yh/ZZD0hbiNytrS1Z9vX1xTYhDQogKnd2dqyxV7sQbboooKgBZ2dnDXcuZrwWRuAZjHYaUSBBTzeBTCbDz7FXAhcXFyxDTRWNA8a4W2KvniEopABI6u/vb0lETU5O8n/d3NzIMhRtJxCl1x4rsb29zRGi3HR0flgngOZGeS41Y69wlIZTHxRBG9kK7O3tsTLojNDiQmkUaKHk7e0tz8NdGCNSEYxtRPZbotBCY97p6SmPU6kUNwMCqDuoR0qgNk1MTMhjtN7o8kQz0qi9gN/vlxs4UfPqao2OZmNjo2V1CsUaZw944uLiIiuvPEeg8MJYbRpVzhFerCdr5ugwPj7Om4iMghZc2f2hk1MSBwwMDKhkmCOIMWOvyGSYh3NbLperTxTayLW1NfeztRO/ngsg5FsZSS4sIAp5MZlM8u9isdh0GnHRIqLwDU1ZE1AjXNiPf/oOOVqek5R5AAAAAElFTkSuQmCC</png>\r\n      </formula>\r\n    </p>\r\n    <p>Следовательно,</p>\r\n    <p>\r\n      <formula>\r\n        <math><![CDATA[<math xmlns="http://www.w3.org/1998/Math/MathML">\r\n  <apply>\r\n    <eq/>\r\n    <ci>m</ci>\r\n    <apply>\r\n      <times/>\r\n      <ci>L</ci>\r\n      <apply>\r\n        <divide/>\r\n        <apply>\r\n          <power/>\r\n          <ci>I</ci>\r\n          <cn>2</cn>\r\n        </apply>\r\n        <apply>\r\n          <times/>\r\n          <cn>2</cn>\r\n          <apply>\r\n            <ci>paren</ci>\r\n            <apply>\r\n              <plus/>\r\n              <apply>\r\n                <plus/>\r\n                <ci>d</ci>\r\n              </apply>\r\n              <apply>\r\n                <times/>\r\n                <ci>c</ci>\r\n                <ci>d</ci>\r\n                <ci>t</ci>\r\n              </apply>\r\n            </apply>\r\n          </apply>\r\n        </apply>\r\n      </apply>\r\n    </apply>\r\n  </apply>\r\n</math>]]></math>\r\n        <png>data:image/png;charset=utf-8;base64,iVBORw0KGgoAAAANSUhEUgAAAHcAAAAcCAYAAABbCiATAAAE4klEQVR42u2aTyh8bRTHlSRJUpIkSUmSJCULC8lGspCUJMlOspBsJEmSkiRJNpIkKUmSpJAkCyVJkpQkSfInSZKet8+pZ3rMvWMG83vNne6pm7lzz5znPM/3POd8z3NFKFd+LBEREXKFrH8uRD8H1vzrghvGILvgusC64IaiTE1NCZjx8fEuuOEosbGxamtry6254SY3NzcqISHBwpRdcMNA5ubmVG1trbM4gQtbYFJfXy911wU3QHl6evqU3mZnZ0N2oZKTk9XV1ZUL7k9YaFtbW8gu0s7OjoqJiXFeq/bXDkxPTwu4h4eHIbtItD/46Mi0PD8/L85HRkaql5cXNTw8LGmISZEqn5+fVXV1tYqKilIDAwNBr2VO3BWO2rk9PT0qPz9fdXR0CNgfHx9yn5eXp7q6uqQ+lpeXq8TExKA6kJGRIYHjLQ8PD2pzc9O9vnk9Pj5awW1ublZJSUlqYmLC87CmpkZ289nZmdw3NjaqtLQ0a4QYpMju8iXX19fyfGhoyPIMR/3ZdS/rpQ9ZPoFbUlKiCgoKPi0wOxeAtVRUVAS116N3xKHt7W3LMyIQR93re5dl55KCqacjIyOeB+/v77JrSdFaqI3j4+NBA5dMwLiM7wTBz9bW1oA5AvyF4GWeP5VAbOBPU1OTZR0F3L29PTEA5deysbEh3x0fH8s9bNYXq/1pWs7MzFRlZWUBtSJklujoaJWenq6Wl5f/BFyCn+zFggcqENDf9u/eNoqLi9Xb29unAGAdIcIWcMfGxmSXmsijyGJqmZycDCqr5awW4Lu7uz3fHRwcCMGyCx5aJgRgU1JS/gTcyspKtbKy8q3fNDQ0qNPT01+Na9og0OFG3sK6EHgWcKmj1FdTqLVEiJa6ujoVFxcnbVEwBHYOaHoX3t7eqqKiIr8pjAAkEAm89fV1lZqaKmBrIgH5wwZvcNCB6SNVVVVSAnZ3d1VWVpYncE9OTuSeuWngtO7+/r7KyckR3d7eXmkNX19fbYPPlMHBQRmf3cSc/OmzBrm5uTIm8/Flw/tED5+1gIv5OtIDLgzYe1EZxPwOHQzSDv1WFhcXfaZws8bbCWyehWYhyCYIPECTQYBYWFiQz6urq6KnJ09QMLYuMUhpaamAen5+Lm2fqUsaJpgICOyamcwXWEtLSxIQdAL4YdfmmfrYJjjJWvf39/LsKxtksP7+fls/vP1z1IsDwOrr67MskCaE/hberv6zIDqwTBveunb8wS44CRYyig5iEwg7fVLpzMzMJ7tf2eDQZ21tzXauBKQjwWWSZj/sDa7mA+wAFoBMw3f+wPXF1gMB106XMbU9Mp8GyZc+wUVn4s1+fdmAk3jrOxpc6mlnZ6d8vri48Ow23R8DumbdvFCH6cMmSfGAR7rT9YrPppDO2TnUUg5yzNqmdXW6DCQtowN/wCa1ks/+guHy8lIIZktLy5c2mBP6+MpJYlikZaLVm0jwF0ABr7CwUEBH6EOZZHZ2tjBLdCGMME5+A1kyhQCBX8BACQrNTtHVBzb6nrH8Ecr29nYhNhzQ4Ld5CGQno6Oj4i+E6ujo6Esb7GZ4Af6abSsC4LaEypGH4n/w7y20Qn/VYwfCR/DP8eDe3d0JuKSy//sQA7ITrHYwWMIhBsCaJ4yOBRfCRCrzl/L+xfEjdTnUXlHij67XpvwHjvzd8WENy28AAAAASUVORK5CYII=</png>\r\n      </formula>\r\n    </p>\r\n    <p>Подставим численные значения и получим 6.67?1000 кг. Впечатляет! </p>\r\n  </solution>\r\n</root>');