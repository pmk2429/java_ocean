package strings;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StripeBotsDetection {

    public static void main(String[] args) {
        process_invites(null);
    }

    public static void process_invites(List<String> invites) {
        if (invites == null) return;

        if (invites.size() < 1 || invites.size() > 100) return;

        // LinkedHashMap to store the frequency of element and maintain insertion order
        Map<Date, Invitee> inviteeMap = new LinkedHashMap<>();
        Date startDate = null, endDate = null;

        for (int i = 0; i < invites.size(); i++) {
            String record = invites.get(i);
            String[] parsedInvitee = record.split(",");

            Invitee invitee = new Invitee();
            long unixSeconds = Long.parseLong(parsedInvitee[0]);
            Date inviteTime = new Date(unixSeconds * 1000L);
            // set time as Date for human readable format
            invitee.setInviteTime(inviteTime);
            if (i == 0) {
                startDate = inviteTime;
            }
            else if (i == invites.size()) {
                endDate = inviteTime;
            }
            // set Event
            invitee.setEventType(EVENT.valueOf(parsedInvitee[1]));
            // set email
            invitee.setEmail(parsedInvitee[2]);

            inviteeMap.put(inviteTime, invitee);
        }
    }

}


class Invitee {
    Date inviteTime;
    EVENT eventType;
    String email;

    public Invitee() {
    }

    public Invitee(Date inviteTime, EVENT eventType, String email) {
        this.inviteTime = inviteTime;
        this.eventType = eventType;
        this.email = email;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    public EVENT getEventType() {
        return eventType;
    }

    public void setEventType(EVENT eventType) {
        this.eventType = eventType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Invitee{" +
            "inviteTime=" + inviteTime +
            ", eventType=" + eventType +
            ", email='" + email + '\'' +
            '}';
    }
}

enum EVENT {
    INVITE_REQUESTED("invite_requested"),
    INVITE_SENT("invite_sent"),
    INVITE_ACTIVATED("invite_activated");

    public final String inviteType;

    private EVENT(String inviteType) {
        this.inviteType = inviteType;
    }
}
