#include "protocol.h"

class redis_protocol : public abstract_protocol {
protected:
    enum response_state { rs_initial, rs_read_bulk, rs_read_line, rs_end_bulk };
    response_state m_response_state;
    unsigned int m_bulk_len;
    size_t m_response_len;

    unsigned int m_total_bulks_count;
    mbulk_size_el* m_current_mbulk;

public:
    redis_protocol() : m_response_state(rs_initial), m_bulk_len(0), m_response_len(0) { }
    virtual redis_protocol* clone(void) { return new redis_protocol(); }
    virtual int select_db(int db);
    virtual int authenticate(const char *credentials);
    virtual int write_command_cluster_slots();
    virtual int write_command_set(const char *key, int key_len, const char *value, int value_len, int expiry, unsigned int offset);
    virtual int write_command_get(const char *key, int key_len, unsigned int offset);
    virtual int write_command_multi_get(const keylist *keylist);
    virtual int write_command_wait(unsigned int num_slaves, unsigned int timeout);
    virtual int parse_response(void);

    // handle arbitrary command
    virtual bool format_arbitrary_command(arbitrary_command &cmd);
    int write_arbitrary_command(const command_arg *arg);
    int write_arbitrary_command(const char *val, int val_len);
};
